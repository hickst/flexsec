package edu.arizona.cs.to

import org.apache.commons.lang.builder.HashCodeBuilder

/**
 * Security User-Role relation class.
 *   Last modified: Correct class doc string.
 */
class SecUserRole implements Serializable {

  SecUser secUser
  SecRole secRole

  static mapping = {
    id composite: ['secRole', 'secUser']
    version false
  }


  boolean equals(other) {
    if (!(other instanceof SecUserRole)) {
      return false
    }

    return (other.secUser?.id == secUser?.id &&
            other.secRole?.id == secRole?.id)
  }

  int hashCode() {
    def builder = new HashCodeBuilder()
    if (secUser) builder.append(secUser.id)
    if (secRole) builder.append(secRole.id)
    builder.toHashCode()
  }


  static SecUserRole get (long secUserId, long secRoleId) {
    find('from SecUserRole where secUser.id=:secUserId and secRole.id=:secRoleId',
         [secUserId: secUserId, secRoleId: secRoleId])
  }


  static SecUserRole create (SecUser secUser, SecRole secRole, boolean flush=false) {
    new SecUserRole(secUser: secUser, secRole: secRole).save(flush: flush, insert: true)
  }


  static boolean remove (SecUser secUser, SecRole secRole, boolean flush = false) {
    SecUserRole instance = SecUserRole.findBySecUserAndSecRole(secUser, secRole)
    if (!instance) {
      return false
    }
    instance.delete(flush: flush)
    return true
  }


  static void removeAll (SecUser secUser) {
    executeUpdate('DELETE FROM SecUserRole WHERE secUser=:secUser', [secUser: secUser])
  }


  static void removeAll (SecRole secRole) {
    executeUpdate('DELETE FROM SecUserRole WHERE secRole=:secRole', [secRole: secRole])
  }

}
