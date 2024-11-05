package main.java.it.unibo.generics.graph.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map;
import java.util.TreeMap;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N>{

    private final LinkedList<N> nodes = new LinkedList<>();
    private final Map<N, LinkedList<N>> edges = new TreeMap<>();

    @Override
    public void addNode(N node) {
        if(nodes.contains(node) || node == null){
            return;
        } else {
            nodes.add(node);
        }
    }

    @Override
    public void addEdge(N source, N target) {
        if(source == null || target == null || !nodes.contains(source) || !nodes.contains(target) ){
            return;
        }
        
        if(edges.containsKey(source)){
            edges.get(source).add(target);
        }
    }

    @Override
    public Set<N> nodeSet() {
        return new TreeSet<N>(nodes);
    }

    @Override
    public Set<N> linkedNodes(N node) {
        return new TreeSet<>(edges.get(node));
    }

    @Override
    public List<N> getPath(N source, N target) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPath'");
    }

}
