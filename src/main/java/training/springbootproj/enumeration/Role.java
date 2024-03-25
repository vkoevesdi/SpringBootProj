package training.springbootproj.enumeration;

import org.h2.engine.Right;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.List;

import static com.fasterxml.jackson.databind.type.LogicalType.Collection;

public enum Role {

    USER;

}

private List<Right> rights = new ArrayList<>();

Role(Right... right) {
    Collection.addAll(this.rights, rights);
}

public List<GrantedAuthority> grantedAuthorities() {
    List authorities = new ArrayList<>();
}
