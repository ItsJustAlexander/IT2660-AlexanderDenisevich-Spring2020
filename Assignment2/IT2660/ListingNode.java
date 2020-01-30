//ListingNode.java

class ListingNode {

    private listpro listing11;

    private ListingNode nextnode;

    public ListingNode(listpro listing11) {

        this.listing11 = listing11;

    }

    public listpro getListing() {

        return listing11;

   }

    public void setListing(listpro listing11) {

        this.listing11 = listing11;

    }

    public ListingNode getnextnode() {

        return nextnode;

    }

    public void setnextnode(ListingNode nextnode) {

        this.nextnode = nextnode;

    }

}

public class Listlinked {

    private ListingNode headnode;

    public Listlinked() {

        headnode = null;

    }

    public void insert(listpro listing11) {

        ListingNode listingNode = new ListingNode(listing11);

        if(headnode == null) {

            headnode = listingNode;

        } else {

            ListingNode tempval = headnode;

            while (tempval.getnextnode() != null) {

                tempval = tempval.getnextnode();

            }

            tempval.setnextnode(listingNode);

        }

    }

    public listpro fetch(String name) {

        ListingNode tempval = headnode;

        while (tempval != null) {

            if(tempval.getListing().getNamedata().equalsIgnoreCase(name)) {

                return tempval.getListing();

            }

            tempval = tempval.getnextnode();

        }

        return null;

    }

    public boolean delete(String name) {

        ListingNode tempval = headnode;

        boolean found = false;

        if(headnode != null) {

           if(headnode.getListing().getNamedata().equalsIgnoreCase(name)) {

                headnode = headnode.getnextnode();

                found = true;

            } else {

                while (tempval.getnextnode() != null) {

                    if (tempval.getnextnode().getListing().getNamedata().equalsIgnoreCase(name)) {

                        found = true;

                        tempval.setnextnode(tempval.getnextnode().getnextnode());

                        break;

                    }

                    tempval = tempval.getnextnode();

                }

            }

        }

        return found;

    }

    public void printAll() {

        ListingNode tempval = headnode;

        while (tempval != null) {

            System.out.println(tempval.getListing().toString());

            tempval = tempval.getnextnode();

        }

    }

}