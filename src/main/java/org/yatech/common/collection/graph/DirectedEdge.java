package org.yatech.common.collection.graph;

public interface DirectedEdge<VK, VT, ET> extends EdgeBase<VK, VT, ET, DirectedGraph<VK, VT, ET>, DirectedVertex<VK, VT, ET>, DirectedEdge<VK, VT, ET>> {

    enum Direction {Vertex1, Vertex2, Both}

    Direction direction();

}
