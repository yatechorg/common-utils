package org.yatech.common.collection.graph;


import org.yatech.common.collection.graph.DirectedEdge.Direction;

public interface DirectedGraph<VK, VT, ET> extends GraphBase<VK, VT, ET, DirectedGraph<VK, VT, ET>, DirectedVertex<VK, VT, ET>, DirectedEdge<VK, VT, ET>> {

    DirectedEdge<VK, VT, ET> connect(DirectedVertex<VK, VT, ET> vertex1, DirectedVertex<VK, VT, ET> vertex2, ET connectionPayload);

    DirectedEdge<VK, VT, ET> connect(DirectedVertex<VK, VT, ET> vertex1, DirectedVertex<VK, VT, ET> vertex2, ET connectionPayload, Direction direction);

}
