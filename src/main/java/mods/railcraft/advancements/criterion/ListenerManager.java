package mods.railcraft.advancements.criterion;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Stream;
import mods.railcraft.util.collections.CollectionTools;
import net.minecraft.advancements.ICriterionInstance;
import net.minecraft.advancements.ICriterionTrigger.Listener;
import net.minecraft.advancements.PlayerAdvancements;
import net.minecraft.util.Tuple;

@Deprecated
final class ListenerManager<T extends ICriterionInstance> {

  private final Map<PlayerAdvancements, Collection<Listener<T>>> map = new HashMap<>();

  void add(PlayerAdvancements advancements, Listener<T> listener) {
    Collection<Listener<T>> collection =
        map.computeIfAbsent(advancements, advancement -> new HashSet<>());
    collection.add(listener);
  }

  void remove(PlayerAdvancements advancements) {
    map.remove(advancements);
  }

  void remove(PlayerAdvancements advancements, Listener<T> toRemove) {
    Collection<Listener<T>> collection = map.get(advancements);
    if (collection != null) {
      collection.remove(toRemove);
    }
  }

  Collection<Listener<T>> get(PlayerAdvancements advancements) {
    return CollectionTools.makeSafeSet(map.get(advancements));
  }

  Stream<Tuple<PlayerAdvancements, Listener<T>>> allStream() {
    return map.entrySet()
        .parallelStream()
        .flatMap(entry -> entry.getValue()
            .parallelStream()
            .map(listener -> new Tuple<>(entry.getKey(), listener)));
  }
}
