package logic;

import java.util.ArrayList;

public class Database {

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public ArrayList<Region> getRegionList() {
        return regionList;
    }

    public void setRegionList(ArrayList<Region> regionList) {
        this.regionList = regionList;
    }

    ArrayList<Player> playerList;
    ArrayList<Region> regionList;

    public Database()
    {
        playerList = new ArrayList<Player>();
        regionList = new ArrayList<Region>();
    }

    public Database(ArrayList<Player> playerList,ArrayList<Region> regionList)
    {
        this.playerList = playerList;
        this.regionList = regionList;
    }


    public Player addPlayer(String name, Region region) throws Exception {
        for (Player p : playerList) {
            if (p.getName().equals(name)) {
                throw new Exception("Player with name " + name + " already exists.");
            }
        }
        Player newPlayer = new Player(name);
        playerList.add(newPlayer);
        region.addPlayerToRegion(newPlayer);

        return newPlayer;
    }
    public boolean addRegion(String name)
    {
        for (Region r:regionList)
        {
            if(r.getName().equals(name)) {
                return false;
            }
        }
        Region r = new Region(name);
        regionList.add(r);
        return true;
    }

    public Region getRegionByName(String name)
    {
        for (Region r:regionList)
        {
            if (r.getName().equals(name))
            {
                return r;
            }
        }
        return null;
    }

    public void addQuest(Player author, Region region, String name, String description)
    {
        Quest q = new Quest(author, region, name, description);
        region.addQuestToRegion(q);
    }
}
