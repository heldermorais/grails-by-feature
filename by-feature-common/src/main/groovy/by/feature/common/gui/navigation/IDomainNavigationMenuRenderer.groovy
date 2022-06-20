package by.feature.common.gui.navigation

import by.feature.common.gui.navigation.item.MenuItem


interface IDomainNavigationMenuRenderer<D> {
    Collection<MenuItem> buildNavigationMenuFor(Integer state )
}