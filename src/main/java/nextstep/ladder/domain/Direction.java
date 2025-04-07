package nextstep.ladder.domain;

public enum Direction {
    LEFT {
        @Override
        public void connect(Junction j1, Junction j2) {
            j1.setLeft(j2);
            j2.setRight(j1);
        }

        @Override
        public boolean canMove(Junction junction, ParticipantName visitor) {
            return junction.hasLeft() && !junction.getLeft().isVisited(visitor);
        }

        @Override
        public Junction move(Junction junction) {
            return junction.getLeft();
        }

    },
    RIGHT {
        @Override
        public void connect(Junction j1, Junction j2) {
            j1.setRight(j2);
            j2.setLeft(j1);
        }

        @Override
        public boolean canMove(Junction junction, ParticipantName visitor) {
            return junction.hasRight() && !junction.getRight().isVisited(visitor);
        }

        @Override
        public Junction move(Junction junction) {
            return junction.getRight();
        }
    },
    DOWN {
        @Override
        public void connect(Junction j1, Junction j2) {
            j1.setDown(j2);
        }

        @Override
        public boolean canMove(Junction junction, ParticipantName visitor) {
            return junction.hasDown() && !junction.getDown().isVisited(visitor);
        }

        @Override
        public Junction move(Junction junction) {
            return junction.getDown();
        }
    };

    public abstract void connect(Junction j1, Junction j2);
    public abstract boolean canMove(Junction junction, ParticipantName visitor);
    public abstract Junction move(Junction junction);
}
