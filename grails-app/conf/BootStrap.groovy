import edu.arizona.cs.to.*

class BootStrap {

  def init = {
    servletContext ->

    // Retrieve or create the initial system roles
    def adminRole = SecRole.findByAuthority('ROLE_ADMIN')
    if (!adminRole)
      adminRole = new SecRole(authority: 'ROLE_ADMIN').save(flush: true, failOnError: true)

    def mentorRole = SecRole.findByAuthority('ROLE_MENTOR')
    if (!mentorRole)
      mentorRole = new SecRole(authority: 'ROLE_MENTOR').save(flush: true, failOnError: true)

    def scholarRole = SecRole.findByAuthority('ROLE_SCHOLAR')
    if (!scholarRole)
      scholarRole = new SecRole(authority: 'ROLE_SCHOLAR').save(flush: true, failOnError: true)

    // Retrieve or create one initial administrator
    def admin0 = SecUser.findByEmail('admin@nowhere.edu')
    if (!admin0) {
      admin0 = new Admin(
        email: 'admin@uaz.edu', affiliation: 'U of Arizona', password: 'test',
        firstName: 'The', lastName: 'Administrator').save(flush: true, failOnError: true)
      if (!admin0.authorities.contains(adminRole))
        SecUserRole.create(admin0, adminRole)
    }

    // Retrieve or create one initial mentor
    def mentor0 = SecUser.findByEmail('mentor@nowhere.edu')
    if (!mentor0) {
      mentor0 = new User(
        email: 'mentor@uaz.edu', affiliation: 'U of Arizona', password: 'test',
        firstName: 'The', lastName: 'Mentor').save(flush: true, failOnError: true)
      if (!mentor0.authorities.contains(mentorRole))
        SecUserRole.create(mentor0, mentorRole)
    }

    // Retrieve or create one initial scholar
    def scholar0 = SecUser.findByEmail('scholar@nowhere.edu')
    if (!scholar0) {
      scholar0 = new User(
        email: 'scholar@uaz.edu', affiliation: 'U of Arizona', password: 'test',
        firstName: 'The', lastName: 'Scholar').save(flush: true, failOnError: true)
      if (!scholar0.authorities.contains(scholarRole))
        SecUserRole.create(scholar0, scholarRole)
    }

    // Create some initial news items, iff they dont already exist
    if (!News.count()) {
      def n1 = new News(text: 'ant').save(flush: true, failOnError: true)
      def n2 = new News(text: 'bat').save(flush: true, failOnError: true)
      def n3 = new News(text: 'cat').save(flush: true, failOnError: true)
    }
  }

  def destroy = {
  }

}
