	public int numOfPeople() {
		int np = 0; //count people number
		Manager manager = new Manager();
		List<Room> rooms = manager.getRoomList();
		for(int i = 0; i < rooms.size(); i++)	np = np + rooms.get(i).getPeople();
		return np;
	}
