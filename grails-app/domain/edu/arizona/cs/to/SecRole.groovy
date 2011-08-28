package edu.arizona.cs.to

/**
 * Security Role.
 *   Last modified: Initial recreation.
 */
class SecRole {

  String authority

  static mapping = {
    cache(true)
  }

  static constraints = {
    authority(blank: false, unique: true)
  }


  String toString () {
    return authority
  }

}
