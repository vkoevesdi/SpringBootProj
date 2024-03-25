package training.springbootproj.enumeration;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static training.springbootproj.enumeration.Right.*;

public enum Role {

    USER(
            TODO_READ,
            TODO_READ_ALL,
            TODO_READ_OPEN,
            TODO_READ_COMPLETED,
            TODO_READ_COUNT_OPEN,
            TODO_READ_COUNT_COMPLETED,
            TODO_CREATE,
            TODO_UPDATE
    ),
    ADMIN(
            TODO_READ,
            TODO_READ_ALL,
            TODO_READ_OPEN,
            TODO_READ_COMPLETED,
            TODO_READ_COUNT_OPEN,
            TODO_READ_COUNT_COMPLETED,
            TODO_CREATE,
            TODO_DELETE,
            TODO_UPDATE
    ),
    ANALYST(
            TODO_READ,
            TODO_READ_ALL,
            TODO_READ_OPEN,
            TODO_READ_COMPLETED,
            TODO_READ_COUNT_OPEN,
            TODO_READ_COUNT_COMPLETED,
            TODO_CREATE,
            TODO_DELETE,
            TODO_UPDATE
    );

    private final List<Right> rights = new ArrayList<>();

    Role(Right... right) {
        Collections.addAll(this.rights, right);
    }

    public List<GrantedAuthority> getGrantedAuthorities() {
        List <GrantedAuthority> authorities = new ArrayList<>();
        for (Right right : rights) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + right.toString()));
        }
        return authorities;
    }
}
