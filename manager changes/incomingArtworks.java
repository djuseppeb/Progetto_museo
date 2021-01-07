//Return the incoming artwork list

public static List<Opera> getIncomingOpera() {
	List<Opera> listaOpere = Manager.getArtList();
	List<Opera> incomingArtworks = new ArrayList<>();
	for (Opera op : listaOpere) {
		if (op.getStatus().equals("In arrivo"))
			incomingArtworks.add(op);
	}
	return incomingArtworks;
}
