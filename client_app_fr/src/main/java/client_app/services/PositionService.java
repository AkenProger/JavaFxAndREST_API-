package client_app.services;

import client_app.models.Position;
import client_app.services.impl.PositionServiceImpl;
import java.util.List;


public interface PositionService  {
    PositionService POSITION_SERVICE = new PositionServiceImpl();
    List<Position> findAll();

    void save(Position position);


}
