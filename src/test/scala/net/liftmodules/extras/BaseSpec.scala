package net.liftmodules
package extras

import org.scalatest._

import net.liftweb._
import common._
import http._
import util._
import Helpers._

trait BaseSpec extends WordSpec with Matchers

trait WithSessionSpec extends BaseSpec {
  def session = new LiftSession("", randomString(20), Empty)

  override protected def withFixture(test: NoArgTest) = {
    S.initIfUninitted(session) { test() }
  }
}
