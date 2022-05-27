package hello.itemservice.domain.item;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class ItemRepositoryTest {

  ItemRepository itemRepository = new ItemRepository();

  @AfterEach
  void afterEach() {
    itemRepository.clearStore();
  }

  @Test
  void save() {
    // given
    Item item = new Item("itemA", 10000, 10);

    // when
    itemRepository.save(item);

    // then
    Item findItem = itemRepository.findById(item.getId());
    assertThat(findItem).isEqualTo(item);
  }

  @Test
  void findAll() {
    // given
    Item itemA = new Item("itemA", 10000, 10);
    Item itemB = new Item("itemA", 10000, 10);

    itemRepository.save(itemA);
    itemRepository.save(itemB);

    // when
    List<Item> result = itemRepository.findAll();

    // then
    assertThat(result).hasSize(2);
    assertThat(result).contains(itemA, itemB);
  }

  @Test
  void update() {
    // given
    Item item = new Item("itemA", 10000, 10);

    Item savedItem = itemRepository.save(item);
    Long itemId = savedItem.getId();

    // when
    Item updateParam = new Item("itemB", 20000, 30);
    itemRepository.update(itemId, updateParam);

    // then
    Item findItem = itemRepository.findById(itemId);

    assertThat(findItem.getItemName()).isEqualTo(updateParam.getItemName());
    assertThat(findItem.getPrice()).isEqualTo(updateParam.getPrice());
    assertThat(findItem.getQuantity()).isEqualTo(updateParam.getQuantity());

  }

}