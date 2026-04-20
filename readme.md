# JGame
*Made by Devin Chalmers*

A turn-based card game built in Java, inspired by [Slay The Spire](https://store.steampowered.com/app/646570/Slay_the_Spire/) and programming themed.

## How to run
1. Make sure you have Java installed (j17+ should be fine)
2. Open the project in IntelliJ (or vsCode)
3. Run `Main.java` found in `/src/main`

Make sure the `cardAssets/`, `UIAssets/`, and `SoundEffects/` folders are in your project root, or the assets won't load.

## Gameplay
- Play cards from your hand each turn by clicking them.
- There are 9 unique cards. (Possibly more in the future)
- Each card costs energy, and you must have enough to play the card. The cost is shown at the top of each card. Your current energy amount is displayed under the **End Turn** button.
- Click **End Turn** to end your turn and let the enemy act, then a new hand is dealt.
- The enemies decision displays at the top right of the screen.
- Use cards that apply **Block** to avoid damage. Similarly, enemies will do the same. Current **Block** amount is displayed by each health bar and resets at the end of every turn.
- Survive through *Python* and *Sea Plus-Plus* languages to win.

## FAQ
### Why is the program not running in VSCode?!
- For some reason, sometimes I have trouble running it in VSCode, though the fix is simple.
- Press Ctrl + Shift + P
- Type "Clean Java Language Server Workspace" and press enter. Click "Reload and delete" in the bottom right color to apply the changes and the game should now work.

### How do I scale the window?
- In `/src/main/GamePanel.java`, you will find a *Scale Window* variable in which you can scale the window. 3 or 4 is recommended.

### How do I add new cards?
- Place art within `/cardAssets`.
- Make a static reference inside `/src/main/ArtLoader.java`.
- Duplicate a card class from `/src/Cards/CardClasses` to use as a reference.
- Replace the overridden *cardAction(Entity player, Entity enemy)* within the new class with whatever you would like the card to do.
- Initialize the card in `/src/Cards/CardInitializer.java` by replicating what's already done. Make sure to replace the parameters to correctly match the card (Name, type cost, art).
- That's it! It's now in the random pool of cards.
### Was AI used?
- AI was used to help with the [Mermaid](https://mermaid.ai/) UML diagram.
### How was the art made?
- The art was made by me using [Aseprite](https://www.aseprite.org/) and [Photoshop](https://www.adobe.com/products/photoshop.html).

## How OOP Concepts Were Used
**Inheritance** — The game is built around inheritance . `Level1` and `Level2` both extend `BaseLevel`, sharing core level logic while overriding their own backgrounds and enemy setups. `PythonEnemyAI` and `CPlusEnemyAI` both extend `OpponentAI`, each with their own move sets and damage values. Every card (`JavaAttack`, `Parry`, `Segfault`, etc.) extends `Card` and overrides `cardAction()` to define its unique effect.

**Polymorphism** — `LevelHandler` holds a `BaseLevel` reference for `currentLevel`, meaning it can point to either `Level1` or `Level2` and call `updateLevel()` or `renderBackground()` without caring which one it is. Same idea with `OpponentAI` — the level just calls `decision()` and `opponentAction()` and the right enemy behavior runs.

**Abstraction** — `BaseLevel` defines the template for what a level needs (`init()`, `updateLevel()`, `checkEndGame()`) without implementing the details, leaving that to the subclasses. This is the same with `Card` and `cardAction()`.

## Mermaid Code
    ---
    config:
    layout: elk
    ---
    classDiagram
    direction TB
    class Main {
    +main(args)
    }

    class GamePanel {
	    +int scaleWindow$
	    +int screenWidth$
	    +int screenHeight$
	    +int finalShrinkCards$
	    +int fps
	    +LevelHandler LevelH
	    +startGameThread()
	    +update()
	    +paintComponent(g)
    }

    class MouseListener {
	    +int mouseX
	    +int mouseY
	    +GamePanel gp
	    +mouseReleased(e)
	    +mouseMoved(e)
    }

    class TurnHandler {
	    +boolean playerTurn
	    +boolean enemyTurn
	    +Rectangle buttonBox
	    +LevelHandler LH
	    +endTurn()
	    +checkEndTurn(x, y)
	    +startEnemyTurn()
	    +endEnemyTurn()
	    +renderTurnButton(g2)
    }

    class ArtLoader {
	    +BufferedImage cardArt$
	    +BufferedImage endTurnArt$
	    +BufferedImage logoArt$
	    +BufferedImage menuTextArt$
	    +BufferedImage winScreenArt$
	    +Clip attackSound$
	    +Clip shieldSound$
	    +Clip cardHover$
	    +Clip noEnergySound$
	    +Font perfectFont$
	    +Font smallPerfectFont$
	    +load()$
	    +playSound(clip, volume)$
    }

    class TextRenderer {
	    +renderText(g2, text, font, color, x, y)$
    }

    class LevelHandler {
	    +TurnHandler turnH
	    +BaseLevel currentLevel
	    +StartMenu startMenu
	    +WinScreen winScreen
	    +Level1 Level1
	    +Level2 Level2
	    +renderLevel(g2)
    }

    class BaseLevel {
	    +Entity player
	    +Entity enemy
	    +CardHandler CH
	    +OpponentAI enemyAI
	    +int energyReplenishAmount
	    +int playerStartingHealth
	    +boolean initialized
	    +boolean enemyHit
	    +int frameCount
	    +boolean frameStatus
	    +init(playerStartingHealth)
	    +updateLevel(g2, turnH)
	    +checkEndGame()
	    +renderBackground(g2)
    }

    class Level1 {
	    +init(playerStartingHealth)
	    +updateLevel(g2, turnH)
	    +renderBackground(g2)
	    +getPreviousFrameCount()
    }

    class Level2 {
	    +init(playerStartingHealth)
	    +updateLevel(g2, turnH)
	    +renderBackground(g2)
	    +getPreviousFrameCount()
    }

    class StartMenu {
	    +int logoWidth
	    +int logoHeight
	    +int textWidth
	    +int textHeight
	    +init(playerStartingHealth)
	    +updateLevel(g2, turnH)
	    +renderBackground(g2)
	    +getPreviousFrameCount()
    }

    class WinScreen {
	    +int logoWidth
	    +int logoHeight
	    +int textWidth
	    +int textHeight
	    +init(playerStartingHealth)
	    +updateLevel(g2, turnH)
	    +renderBackground(g2)
	    +getPreviousFrameCount()
    }

    class Entity {
	    +int health
	    +int maxHealth
	    +int block
	    +int vulnerability
	    +String name
	    +HealthBar healthBar
	    +BaseLevel level
	    +Clip hurtSound
	    +damage(incoming)
	    +addBlock(amount)
	    +setBlock(amount)
	    +applyVulnerability(amount)
	    +lowerVulnerability()
	    +renderEntityHit()
    }

    class HealthBar {
	    +Entity entity
	    +String name
	    +double widthOfBar
	    +int heightOfBar
	    +renderHealthBar(maxHealth, health, block, g2, topLeft, shiftRight, shiftDown, font)
    }

    class OpponentAI {
	    +Entity player
	    +Entity self
	    +LevelHandler LH
	    +String decisionString
	    +String[] moves
	    +int index
	    +decision()
	    +opponentAction()
	    +damagePlayer(incoming)
	    +getRandomNumber(min, max)
	    +renderOpponentDecision(g2, font)
    }

    class PythonEnemyAI {
	    +int maxDamageAmount
	    +int minDamageAmount
	    +int randomDamageAmount
	    +int maxHealAmt
	    +int maxBlockAmt
	    +decision()
	    +opponentAction()
	    +damagePlayer(incoming)
	    +getRandomNumber(min, max)
    }

    class CPlusEnemyAI {
	    +int maxDamageAmount
	    +int minDamageAmount
	    +int randomDamageAmount
	    +int maxHealAmt
	    +int maxBlockAmt
	    +decision()
	    +opponentAction()
	    +damagePlayer(incoming)
    }

    class Card {
	    +String name
	    +String type
	    +int energyCost
	    +int value
	    +boolean Hovered
	    +BufferedImage sprite
	    +CardHandler CH
	    +drawToScreen(g2, card, x, y, cardW, cardH, CH)
	    +cardAction(player, enemy)
    }

    class CardHandler {
	    +ArrayList~Card~ hand
	    +ArrayList~Rectangle~ cardBounds
	    +CardInitializer CI
	    +int energy
	    +int cardAmount
	    +int hoveredCard
	    +Entity player
	    +Entity enemy
	    +TurnHandler turnH
	    +calculateCardX(i)
	    +calculateCardY(i)
	    +getDynamicCardWidth()
	    +getDynamicCardHeight()
	    +buildDeck()
	    +renderDeck(g2)
	    +handleCardBounds(g2)
	    +checkCardClick(mouseX, mouseY)
	    +checkCardHover(mouseX, mouseY)
    }

    class CardInitializer {
	    +ArrayList~Card~ allCards
	    +CardInitializer(CH)
	    +randomCard()
    }

    class JavaAttack {
	    +cardAction(player, enemy)
    }

    class Infinite {
	    +cardAction(player, enemy)
    }

    class Memory {
	    +cardAction(player, enemy)
    }

    class Firewall {
	    +cardAction(player, enemy)
    }

    class Compile {
	    +cardAction(player, enemy)
    }

    class Parry {
	    +cardAction(player, enemy)
    }

    class Ping {
	    +cardAction(player, enemy)
    }

    class Polymorphism {
	    +cardAction(player, enemy)
    }

    class Segfault {
	    +cardAction(player, enemy)
    }

    BaseLevel <|-- Level1
    BaseLevel <|-- Level2
    BaseLevel <|-- StartMenu
    BaseLevel <|-- WinScreen
    OpponentAI <|-- PythonEnemyAI
    OpponentAI <|-- CPlusEnemyAI
    Card <|-- JavaAttack
    Card <|-- Infinite
    Card <|-- Memory
    Card <|-- Firewall
    Card <|-- Compile
    Card <|-- Parry
    Card <|-- Ping
    Card <|-- Polymorphism
    Card <|-- Segfault
    Main --> GamePanel
    GamePanel --> LevelHandler
    GamePanel --> MouseListener
    LevelHandler --> TurnHandler
    LevelHandler --> BaseLevel
    LevelHandler --> Level1
    LevelHandler --> Level2
    LevelHandler --> StartMenu
    LevelHandler --> WinScreen
    BaseLevel --> Entity : player
    BaseLevel --> Entity : enemy
    BaseLevel --> CardHandler
    BaseLevel --> OpponentAI
    Entity --> HealthBar
    Entity --> BaseLevel : level ref
    CardHandler --> CardInitializer
    CardHandler --> Entity : player
    CardHandler --> Entity : enemy
    CardHandler --> TurnHandler
    MouseListener --> GamePanel
    TurnHandler --> LevelHandler
    Level1 --> PythonEnemyAI
    Level2 --> CPlusEnemyAI
    CardInitializer --> Card