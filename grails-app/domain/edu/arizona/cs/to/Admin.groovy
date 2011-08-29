package edu.arizona.cs.to

/**
 * Admin class.
 *   Last modified: Initial recreation.
 */
class Admin extends User implements Serializable {

  static constraints = {
  }

  static mapping = {
    cache(true)
  }

  String logString() {
    return "<Admin: email=${email}, first=${firstName}, last=${lastName}, fbId=${facebookId?:''}>"
  }

}
