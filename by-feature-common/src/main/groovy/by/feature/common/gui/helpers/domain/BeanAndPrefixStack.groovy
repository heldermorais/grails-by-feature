package by.feature.common.gui.helpers.domain

class BeanAndPrefixStack extends Stack<BeanAndPrefix> {

    Object getBean() {
        empty() ? null : peek().bean
    }

    String getPrefix() {
        empty() ? null : peek().prefix
    }

    Map<String, Object> getInnerAttributes() {
        empty() ? [:] : peek().innerAttributes
    }

    String toString() {
        bean?.toString() ?: ''
    }

}
