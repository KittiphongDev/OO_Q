package logic;

import java.util.ArrayList;

import static logic.TemplateType.*;

public class Server {

    public String getName() {
        if (name.isBlank())
        {
            return owner.getName()+" home";
        }
        else{
            return name;
        }
    }

    public User getOwner() {
        return owner;
    }

    public ArrayList<Channel> getChannelList() {
        return channelList;
    }

    public ArrayList<User> getMemberList() {
        return memberList;
    }

    String name;
    User owner;
    ArrayList<Channel> channelList;
    ArrayList<User> memberList;

    public Server(String name, User owner, TemplateType template)
    {
        this.owner = owner;

        memberList = new ArrayList<User>();
        channelList = new ArrayList<Channel>();

        this.addUser(owner);

        this.name = name;

        if(template == BASIC) {
            addChannel(owner,"general");
        } else if (template == GAMING) {
            addChannel(owner,"gaming");
        } else if (template == STUDY) {
            addChannel(owner,"homework-help");
        }
    }

    public Channel addChannel(User user, String channelName)
    {
        if (user.equals(owner))
        {
            Channel ch = new Channel(channelName);
            channelList.add(ch);
            return ch;
        }
        return null;
    }

    public User addUser(User user)
    {
        if (memberList.contains(user))
        {
            return null;
        }
        else{
            memberList.add(user);
            user.addJoinedServersList(this);
            return user;
        }
    }

    public boolean kickUser(User kicker, User kicked) throws Exception
    {
        if (kicker != owner)
        {
            throw new Exception("no permission to kick.");
        }
        else if (!memberList.contains(kicked)||kicked == owner)
        {
            return false;
        }
        else{
            kicked.getJoinedServersList().remove(this);
            memberList.remove(kicked);
            return true;
        }
    }

    public void setName(String name)
    {
        if (name.isBlank())
        {
            this.name = owner.getName()+" home";
        }
        else{
            this.name = name;
        }
    }

    public boolean isMemberInServer(User userToCheck)
    {
        if (memberList.contains(userToCheck))
        {
            return true;
        }
        else{
            return false;
        }
    }
}
