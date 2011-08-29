package edu.arizona.cs.to

import grails.plugins.springsecurity.Secured

/**
 * Controller for operations on User superclass.
 *   Last modified: Initial recreation.
 */
@Secured(['ROLE_ADMIN'])
class UserController {

  // Force sensitive actions to only accept POST requests
  static allowedMethods = []

  // The default action for this controller
  static defaultAction = 'list'

  def scaffold = true

}
