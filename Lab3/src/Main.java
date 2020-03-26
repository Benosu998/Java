public class Main {

    public static void main(String[] args) {
        Hotel v1 = new Hotel("California");
        Museum v2 = new Museum("Museum");
        Museum v3 = new Museum("Nasa");
        Church v4 = new Church("Sf. Andrei");
        Church v5 = new Church("Sf. Gheorge");
        Restaurant v6 = new Restaurant("Palas");
        v2.setHour();
        v3.setHour();
        v4.setHour();
        v5.setHour();
        v2.setPrice(12.5);
        v3.setPrice(10.3);
        TravelMap map = new TravelMap();
        map.addNode(v1);
        map.addNode(v2); //maybe put the nodes in an array?
        map.addNode(v3);
        map.addNode(v4);
        map.addNode(v5);
        map.addNode(v6);
        map.addEdge(v1, v2, 15); //two way street by default
        map.addEdge(v1, v3, 10);
        map.addEdge(v3, v2, 1, false); //one-way street
        map.addEdge(v3, v4, 1);
        map.addEdge(v4, v5, 1);
        map.addEdge(v2, v6, 10);
        System.out.println("The map is: \n" + map.getNodes());
        System.out.println(map);

        System.out.println(v4.getOpenHour());
        map.getNodes().stream()
                .filter(node -> (node instanceof Visitable))
                .filter(node -> !(node instanceof Payable))
                .sorted((arg0, arg1) -> {
                    return arg0.getName().compareTo(arg1.getName());
                })
                .forEach(s -> System.out.println(s.getName()));

        System.out.println(map.getNodes().stream()
                .filter(node -> (node instanceof Payable))
                .mapToDouble(Node::getPrice).average().getAsDouble());
    }
}
