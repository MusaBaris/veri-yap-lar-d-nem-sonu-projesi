
public class PlaylistNode {
	
	    private Song song;         
	    private PlaylistNode next; 
	    private PlaylistNode prev; 

	    
	    public PlaylistNode(Song song) {
	        this.song = song;
	        this.next = null;
	        this.prev = null;
	    }


	    public Song getSong() {
	        return song;
	    }

	    public void setSong(Song song) {
	        this.song = song;
	    }

	    public PlaylistNode getNext() {
	        return next;
	    }

	    public void setNext(PlaylistNode next) {
	        this.next = next;
	    }

	    public PlaylistNode getPrev() {
	        return prev;
	    }

	    public void setPrev(PlaylistNode prev) {
	        this.prev = prev;
	    }
	}

