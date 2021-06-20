package hellojpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.websocket.server.ServerEndpoint;

@Entity
@Getter
@Setter
public class Album extends Item{

    private String artist;
    private String etc;

}
