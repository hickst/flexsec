package edu.arizona.cs.to

/**
 * Abstract User class.
 *   Last modified: Initial recreation.
 */
class User extends SecUser implements Serializable {

  String facebookId
  String firstName
  String lastName
  String affiliation

  static constraints = {
    facebookId(nullable: true, blank: false)
    firstName(blank: false, maxSize: 20)
    lastName(blank: false, maxSize: 20)
    affiliation(nullable: true, blank: false, maxSize: 80)
  }

  static mapping = {
    cache(true)
  }


  String logString() {
    return "<User: email=${email}, first=${firstName}, last=${lastName}, fbId=${facebookId?:''}>"
  }

  String publicName () {
    Utilities.makePublicName(firstName, lastName)
  }

  String toString () {
    return email
  }

}
