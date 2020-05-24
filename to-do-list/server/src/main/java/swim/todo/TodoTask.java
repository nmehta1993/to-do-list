package swim.todo;

import swim.api.SwimRoute;
import swim.api.agent.AgentType;
import swim.api.plane.AbstractPlane;
import swim.api.server.ServerContext;
import swim.loader.ServerLoader;

import java.io.IOException;

public class TodoTask extends AbstractPlane {
    @SwimRoute("/totask")
    final AgentType<ListAgent> mainListAgent = agentClass(ListAgent.class);

    @SwimRoute("/totask/:id")
    final AgentType<ListAgent> idListAgent = agentClass(ListAgent.class);

    @Override
    public void didStart() {
        System.out.println("Todo app started");
        // context.command("/unit/master", "WAKEUP", Value.absent());
    }

    public static void main(String[] args) throws IOException {
        final ServerContext server = ServerLoader.load(TodoPlane.class.getModule()).serverContext();
        server.start();
        server.run();
    }
}
