package edu.arizona.cs.to

import grails.plugins.springsecurity.Secured

// @Secured(['ROLE_ADMIN'])
class NewsController {

  // Force sensitive actions to only accept POST requests
  static allowedMethods = []

  /** Injected news manager service. */
  def newsService

  // The default action for this controller
  static defaultAction = 'list'

  def scaffold = true


  @Secured(['ROLE_ADMIN', 'ROLE_MENTOR', 'ROLE_SCHOLAR'])
  def createItem = {
    def item = newsService.createItem(new News(params))
    render(view: 'listNewsItems', model: [ 'news': [item] ])
  }


  def findAll = {
    def news = newsService.findAll()
    render(view: 'listNewsItems', model: [ 'news': news ])
  }


  @Secured(['ROLE_ADMIN', 'ROLE_MENTOR', 'ROLE_SCHOLAR'])
  def findByText = {
    def text = params.text?.trim()
    if (!text) {
      response.sendError(
        400, "ERROR: a news item text string must be given in the 'text' argument")
      return
    }
    def item = newsService.findByText(text)
    render(view: 'listNewsItems', model: [ 'news': [item] ])
  }


  @Secured(['ROLE_ADMIN'])
  def findById = {
    def id = params.id as Long
    if (!id) {
      response.sendError(400, "ERROR: a news item ID must be given in the 'id' argument")
      return
    }
    def item = newsService.findById(id)
    render(view: 'listNewsItems', model: [ 'news': [item] ])
  }


  @Secured(['ROLE_ADMIN', 'ROLE_MENTOR'])
  def update = {
    def id = params.id as Long
    if (!id) {
      response.sendError(400, "ERROR: a news item ID must be given in the 'id' argument")
      return
    }

    def item = newsService.update(id, params)
    if (item)
      render(view: 'listNewsItems', model: [ 'news': [item] ])
    else
      response.sendError(400, "ERROR: Unable to update news item '${id}' with params.")
    return
  }


  @Secured(['ROLE_ADMIN'])
  def remove = {
    def id = params.id as Long
    if (!id) {
      response.sendError(400, "ERROR: a news item ID must be given in the 'id' argument")
      return
    }
    response.setContentType('text/plain')
    if (newsService.remove(id))
      render("OK: News item '${id}' deleted.")
    else
      render("ERROR: Unable to delete news item '${id}'.")
  }


  @Secured(['ROLE_MENTOR'])
  def mentorAll = {
    def news = newsService.findAll()
    render(view: 'listNewsItems', model: [ 'news': news ])
  }

  @Secured(['ROLE_SCHOLAR'])
  def scholarAll = {
    def news = newsService.findAll()
    render(view: 'listNewsItems', model: [ 'news': news ])
  }

}
