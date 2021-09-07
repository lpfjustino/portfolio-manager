package exception

data class DBException(override val message: String = "Something blew up on the DB.") : Throwable()
