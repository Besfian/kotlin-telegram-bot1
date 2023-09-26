import org.telegram.telegrambots.bots.DefaultBotOptions
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException

class MyBot(
    options: DefaultBotOptions
) : TelegramLongPollingBot(options) {
    override fun getBotUsername(): String {
        // Здесь укажите имя вашего бота
        return "BesfianBot"
    }

    override fun getBotToken(): String {
        // Здесь укажите токен вашего бота
        return "6413829984:AAHyPJcYdvjsEHqeSYWS1AiLe9ICxwjna8M"
    }

    override fun onUpdateReceived(update: Update) {
        if (update.hasMessage() && update.message.hasText()) {
            val message = update.message
            val chatId = message.chatId
            var responseText: String? =null
            if (message.text=="/add"){
                responseText ="Введите команду: "
            }
//            val responseText = processMessage(message.text)

            val responseMessage = SendMessage()
            responseMessage.chatId = chatId.toString()
            responseMessage.text = responseText!!

            try {
                execute(responseMessage)
            } catch (e: TelegramApiException) {
                e.printStackTrace()
            }
        }
    }

//    private fun processMessage(inputText: String): String {
//        // Обработка входящего текста и формирование ответа
//        if (inputText == "/start") {
//            return "Привет! Я ваш телеграм-бот."
//        }
//        if (inputText == "/add") {
//            return "Введите команду: "
//        }
//        else {
//            return "Я не понимаю вашу команду."
//        }
//    }

    private fun processMessage(inputText: String): String {
        // Обработка входящего текста и формирование ответа
        if (inputText == "/start") {
            return "Привет! Я ваш телеграм-бот."
        }
        if (inputText == "/add") {
            return "Введите команду: "
        } else {
            return "Я не понимаю вашу команду."
        }
    }
}
