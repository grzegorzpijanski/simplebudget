package com.typicaldev.simplebudget.event;

import com.google.common.eventbus.EventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bus {

    private final EventBus eventBus;

    @Autowired
    public Bus(final EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public interface Passenger { }

    public interface Event { }

    public void getIn(final Passenger who) {
        eventBus.register(who);
    }

    public void getOut(final Passenger who) {
        eventBus.unregister(who);
    }

    public void yell(final Event about) {

    }
}
