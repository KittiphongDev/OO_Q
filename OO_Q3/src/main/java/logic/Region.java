package logic;

import java.util.ArrayList;

import static java.lang.Math.round;
import static logic.Status.AVAILABLE;

public class Region {

    public String getName() {
        if (name.isBlank())
        {
            return "Nowhere";
        }
        else {
            return name;
        }
    }

    public void setName(String name) {

        if (name.isBlank())
        {
            this.name = "Nowhere";
        }
        else{
            this.name = name;
        }
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public ArrayList<Quest> getQuestList() {
        return questList;
    }

    public void setQuestList(ArrayList<Quest> questList) {
        this.questList = questList;
    }

    String name;
    ArrayList<Player> playerList;
    ArrayList<Quest> questList;

    public Region(String name)
    {
        playerList = new ArrayList<Player>();
        questList = new ArrayList<Quest>();
        this.name = name;
    }

    public int getPlayerCount()
    {
        return playerList.size();
    }

    public double getRegionRank(){
        double avg = 0f;
        for (Player p:playerList)
        {
            avg += p.getRank();
        }
        avg = avg/playerList.size();
        return round(avg*100.0)/100.0;
    }

    public ArrayList<Quest> getAvailableQuests(Player viewer)
    {
        ArrayList<Quest> viewerQuestList;
        viewerQuestList = new ArrayList<Quest>();
        for(Quest q:questList)
        {
            if (q.getStatus() == AVAILABLE && q.getAuthor() != viewer)
            {
                viewerQuestList.add(q);
            }
        }
        return viewerQuestList;
    }

    public void addPlayerToRegion(Player p)
    {
        playerList.add(p);
    }

    public void addQuestToRegion(Quest q)
    {
        questList.add(q);
    }
}
