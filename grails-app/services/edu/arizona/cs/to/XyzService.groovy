package edu.arizona.cs.to

import grails.plugins.springsecurity.Secured
import org.springframework.flex.remoting.RemotingDestination

@RemotingDestination(channels = ['my-amf'])
class XyzService {

  static String value

  String currentValue() {
    println "currentValue called...."
    return "This is the current value: ${value}"
  }

  @Secured(['ROLE_ADMIN'])
  def createValue(String value) {
    println "createValue(${value}) called...."
    this.value = value
  }

  @Secured(['ROLE_ADMIN'])
  String adminView() {
    println "Admin view called...."
    def rval = "This is the current value: ${value} as seen by the ADMIN"
    return rval
  }

  @Secured(['ROLE_MENTOR'])
  String mentorView() {
    println "Mentor view called...."
    def rval = "This is the current value: ${value} as seen by the MENTOR"
    return rval
  }

  @Secured(['ROLE_SCHOLAR'])
  String scholarView() {
    println "Scholar view called...."
    def rval = "This is the current value: ${value} as seen by the SCHOLAR"
    return rval
  }

}
