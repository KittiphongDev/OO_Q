package logic;

import java.util.ArrayList;

public class Channel {
    public String getName() {
        if (name.isBlank())
        {
            return "off-topic";
        }
        else{
            return name;
        }
    }

    public void setName(String name) {
        if (name.isBlank())
        {
            this.name = "off-topic";
        }
        else{
            this.name = name;
        }
    }

    public ArrayList<Message> getMessageList() {
        return messageList;
    }

    String name;
    ArrayList<Message> messageList;

    public Channel(String name)
    {
        this.name = name;
        messageList = new ArrayList<Message>();
    }

    public void addMessage(Message message)
    {
        messageList.add(message);
    }

    public int getMessageCount()
    {
        return messageList.size();
    }

}
