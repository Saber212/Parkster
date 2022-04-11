package se.parkster.rps;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
public class Database {
    private final ConcurrentMap<UUID, Greeting> state = new ConcurrentHashMap<>();

    public Collection<Greeting> findAll() {
        return state.values();
    }

    public void save(Greeting greeting) {
        state.put(greeting.id(), greeting);
    }

    public Optional<Greeting> findById(UUID id) {
        return Optional.ofNullable(state.get(id));
    }


    public void clear() {
        state.clear();
    }
}
