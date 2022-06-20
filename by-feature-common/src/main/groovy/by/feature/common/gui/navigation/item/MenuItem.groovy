package by.feature.common.gui.navigation.item

import groovy.transform.builder.Builder

@Builder
class MenuItem {

    String cssClasses
    String href
    String label

    String iconName

}
