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

  @Secured(['ROLE_MENTOR', 'ROLE_SCHOLAR'])
  String viewValue() {
    println "viewValue called...."
    def rval = "This is the created value: ${value}"
    return rval
  }

}
