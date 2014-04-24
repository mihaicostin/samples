package controllers

import play.mvc.{Result, Results}

object UsersAction {

  def save(name: String): Result = {
    Results.ok("Saved " + name)
  }

}
