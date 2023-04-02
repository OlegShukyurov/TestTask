
import spock.lang.Specification

class AssociativeArrayTest extends Specification{

    def "test getAssociativeMap method with non-empty list"() {
        given:
        def elements = ["a", "b", "c"]

        when:
        def result = AssociativeArray.getAssociativeMap(elements)

        then:
        result.size() == 3
        result["a"] == 1
        result["b"] == 1
        result["c"] == 1
    }

    def "test getAssociativeMap method with empty list"() {
        given:
        def elements = []

        when:
        def ex = null
        try {
            AssociativeArray.getAssociativeMap(elements)
        } catch (RuntimeException e) {
            ex = e
        }

        then:
        ex.message != null
    }

    def "test getAssociativeMap method with null list"() {
        given:
        def elements = null

        when:
        def ex = null
        try {
            AssociativeArray.getAssociativeMap(elements)
        } catch (RuntimeException e) {
            ex = e
        }

        then:
        ex.message != null
    }
}
