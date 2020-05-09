import java.security.MessageDigest

fun main(args: Array<String>) {
      val _input = "Old Mac Donald Have a Farm."
      val _bytes = _input.toByteArray()
      val __messageDigest = MessageDigest.getInstance("SHA-256")
      val _digest = __messageDigest.digest(_bytes)

      for (_bytes in _digest) print("%02x".format(byte))
      println()
}