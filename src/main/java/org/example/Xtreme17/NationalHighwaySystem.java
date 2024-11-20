package org.example.Xtreme17;

import java.util.*;

/**
 * @author pc
 * @description 功能描述
 * @create 2023/10/29 4:43
 */
class City {
    String name;
    List<Edge> edges;

    public City(String name) {
        this.name = name;
        this.edges = new ArrayList<>();
    }
}

class Edge {
    City city1;
    City city2;
    int cost;

    public Edge(City city1, City city2, int cost) {
        this.city1 = city1;
        this.city2 = city2;
        this.cost = cost;
    }
}

public class NationalHighwaySystem {
    /**
     * 输入一个整数n，表示有成本估算的潜在道路数量
     * 接下来n行格式如下：ni,nj,cij
     * 其中ni是一个城市名，nj是一个城市名，cij是一个整数，代表连接两个城市的成本
     * 输出符合上述要求的高速公路系统的成本，没有则输出-1
     *
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        Map<String, City> cityMap = new HashMap<>();
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String ni = input[0];
            String nj = input[1];
            int cij = Integer.parseInt(input[2]);

            City city1 = cityMap.getOrDefault(ni, new City(ni));
            City city2 = cityMap.getOrDefault(nj, new City(nj));

            Edge edge = new Edge(city1, city2, cij);
            city1.edges.add(edge);
            city2.edges.add(edge);

            cityMap.put(ni, city1);
            cityMap.put(nj, city2);

            edges.add(edge);
        }

        int totalCost = calculateMinimumCost(cityMap, edges);
        System.out.println(totalCost);
    }

    public static int calculateMinimumCost(Map<String, City> cityMap, List<Edge> edges) {
        Set<City> visitedCities = new HashSet<>();
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.cost));

        City startCity = cityMap.entrySet().iterator().next().getValue();
        visitedCities.add(startCity);
        priorityQueue.addAll(startCity.edges);

        int totalCost = 0;

        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            City city = edge.city1 == startCity ? edge.city2 : edge.city1;

            if (!visitedCities.contains(city)) {
                System.out.println(edge.city1.name + " " + edge.city2.name + " " + edge.cost);
                visitedCities.add(city);
                totalCost += edge.cost;
                priorityQueue.addAll(city.edges);
            }
        }

        return visitedCities.size() == cityMap.size() ? totalCost : -1;
    }

}
