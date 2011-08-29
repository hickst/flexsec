package edu.arizona.cs.to

//import grails.plugins.springsecurity.Secured
import org.springframework.flex.remoting.RemotingDestination

@RemotingDestination(channels = ['my-amf'])
class NewsService {

//  @Secured(['ROLE_ADMIN', 'ROLE_MENTOR', 'ROLE_SCHOLAR'])
  News createItem (News item) {
    if (!item)
      return null
    item.id = null
    item.save()
    return item
  }

//  @Secured(['ROLE_MENTOR'])
  List findAll () {
    return News.list()
  }

//  @Secured(['ROLE_ADMIN', 'ROLE_MENTOR', 'ROLE_SCHOLAR'])
  News findByText (String text) {
    return News.findByText(text)
  }

//  @Secured(['ROLE_ADMIN', 'ROLE_MENTOR'])
  News findById (long id) {
    return News.get(id)
  }

//  @Secured(['ROLE_ADMIN', 'ROLE_MENTOR'])
  News update (long id, params=[]) {
    News item = News.get(id)
    if (!item)
      return null
    item.properties = params
    if (item.validate() && item.save())
      return item
  }

//  @Secured(['ROLE_ADMIN'])
  boolean remove (long id) {
    News.get(id)?.delete()
    return true
  }

}
