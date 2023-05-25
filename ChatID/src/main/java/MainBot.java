import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MainBot  extends TelegramLongPollingBot {
    String botUser, botToken, example;
    String s_ism, s_fam, s_username, s_chatId, s_bio, username;
    public void onUpdateReceived(Update update) {
        example = "UZB: Tilni tanlang!\n\nENG: Tilni tanlang!\n\nРУС:  Tilni tanlang!";
        if (update.hasMessage() && update.getMessage().hasText()){
            Message message = update.getMessage();
            String text = message.getText();
            System.out.println(message);
            String chatId =message.getChatId().toString();
            SendMessage sendMessage = new SendMessage();
            SendMessage sendMessage2 = new SendMessage();
            s_ism = message.getChat().getFirstName();
            s_chatId = chatId;
            String matn = "<b>Salom!  </b>" + s_ism
                    + "\n\n<b>ID:  </b>" + s_chatId;
            String m = "<b>Dasturchi :  </b>@Jasurbek_JizPI_JFR";
            if (text.equals("/start")){
                sendMessage.setChatId(chatId);
                sendMessage.setText(matn);
                sendMessage.setParseMode(ParseMode.HTML);
                sendMessage2.setChatId(chatId);
                sendMessage2.setText(m);
                sendMessage2.setParseMode(ParseMode.HTML);
            }else
                sendMessage.setChatId(chatId);
            sendMessage.setText(matn);
            sendMessage.setParseMode(ParseMode.HTML);
            sendMessage2.setChatId(chatId);
            sendMessage2.setText(m);
            sendMessage2.setParseMode(ParseMode.HTML);
            try {
                execute(sendMessage);
                try {
                    execute(sendMessage2);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
    public String getBotUsername() {
        botUser = "User_ChatID_bot";
        return botUser; }
    @Override
    public String getBotToken() {
        botToken = "5830707311:AAFAHeBdQNVt2kxGH-BwnmSyTNs7yWSs1qw";
        return botToken; }
}
