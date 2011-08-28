import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils

/**
 * Logout Controller.
 *   Last modified: Generated by Spring Security Plugin, then reformatted.
 */
class LogoutController {

  // The default action for this controller
  def defaultAction = 'index'


  /**
   * Index action. Redirects to the Spring security logout uri: '/j_spring_security_logout'.
   */
  def index = {
    // Note: put any pre-logout code here
    redirect(uri: SpringSecurityUtils.securityConfig.logout.filterProcessesUrl)
  }

}
