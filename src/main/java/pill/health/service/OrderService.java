package pill.health.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pill.health.entity.item.Item;
import pill.health.entity.order.OrderBase;
import pill.health.repository.ItemRepository;
import pill.health.repository.OrderRepository;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)

public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional
    public void save(OrderBase orderBase) {
        orderRepository.save(orderBase);
    }

    @Transactional
    public void delete(OrderBase orderBase) {
        orderRepository.delete(orderBase);
    }
}
