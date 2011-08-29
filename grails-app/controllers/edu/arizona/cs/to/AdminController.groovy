package edu.arizona.cs.to

import grails.plugins.springsecurity.Secured

/**
 * Admin Controller.
 *   Last modified: Initial recreation.
 */
@Secured(['ROLE_ADMIN'])
class AdminController {

  // Force sensitive actions to only accept POST requests
  static allowedMethods = []

  // The default action for this controller
  static defaultAction = 'list'

  def scaffold = true

}
