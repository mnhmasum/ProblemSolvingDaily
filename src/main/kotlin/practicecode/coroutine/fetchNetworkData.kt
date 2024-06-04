package practicecode.coroutine

import kotlinx.coroutines.*


suspend fun fetchNetworkData(): String {
    // Simulate a network call
    delay(1000L)
    return "Network data"
}

fun main() {
    runBlocking {
        println("SOmething is")
        // Launch a coroutine on the main thread
        launch() {
            // Perform a network call in the IO dispatcher
            val data = fetchNetworkData()
            // Update UI with the fetched data
            println("Data fetched: $data")
        }

    }


}