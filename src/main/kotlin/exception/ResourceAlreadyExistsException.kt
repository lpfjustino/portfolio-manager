package exception

data class ResourceAlreadyExistsException(override val message: String = "Resource already exists.") : Throwable()
