import spock.lang.Specification
import Character


/**
 * Created by mholtman on 9/29/15.
 */
class CharacterSpec extends Specification {


    def 'has a default name'() {
        def character = new Character()

        expect:
        character.name == "Default Name"
    }


}