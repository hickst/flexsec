package edu.arizona.cs.to

/**
 * Abstract Security User class.
 *   Last modified: Initial recreation.
 */
class SecUser implements Comparable, Serializable {

  transient springSecurityService

  Date dateCreated
  Date lastUpdated

  String email                              // we use email address as user id field
  String password

  boolean accountExpired = false
  boolean accountLocked = false
  boolean enabled = true
  boolean passwordExpired = false

  static constraints = {
    email(blank: false, unique: true)
    password(blank: false)
    enabled()
    accountExpired()
    accountLocked()
    passwordExpired()
  }

  static mapping = {
    cache(true)

    password(column: '`password`')
  }


  // sort by email, by default
  int compareTo (other) {
    return this.email <=> other.email
  }


  def beforeInsert() {
    encodePassword()
  }

  def beforeUpdate() {
    if (isDirty('password')) {
      encodePassword()
    }
  }

  protected void encodePassword() {
    password = springSecurityService.encodePassword(password)
  }


  Set<SecRole> getAuthorities() {
    SecUserRole.findAllBySecUser(this).collect { it.secRole } as Set
  }


  String logString() {
    return "<SecUser: email=${email}, dC=${dateCreated?:''}, lUpdt=${lastUpdated?:''}, EN/AL/AX/PX=${enabled}/${accountLocked}/${accountExpired}/${passwordExpired}>"
  }

  String toString () {
    return email
  }

}
