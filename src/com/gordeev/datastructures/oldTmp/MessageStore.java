package com.gordeev.datastructures.oldTmp;

import java.util.Collection;

public interface MessageStore {

    void persist(Message message);

    void persist(Collection<Message> list);

}
