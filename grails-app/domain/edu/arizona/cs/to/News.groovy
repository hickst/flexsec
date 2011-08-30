package edu.arizona.cs.to

/**
 * Class to represent a single news item.
 *   Last modified: Initial recreation.
 */
class News implements Serializable {

  Date dateCreated = new Date()

  String text

  static constraints = {
    text(blank: false, maxSize: 2000)
  }

  static mapping = {
    cache(false)
  }


  /** Default, empty constructor. */
  public News () {}

  /** Constructor taking the news item message. */
  public News (item) {
    if (item)
      text = item
  }


  String logString() {
    return "<News: text=${textPrefix()}>"
  }

  String textPrefix() {
    if (!text) return ''
    def len = -1 + text.size()
    return text[0..Math.min(39, len)]       // take first 40 characters
  }

  String toString() {
    return textPrefix()
  }

}
