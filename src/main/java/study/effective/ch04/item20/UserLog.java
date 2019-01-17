package study.effective.ch04.item20;

import lombok.extern.slf4j.Slf4j;

public interface UserLog {
    void print(String msg);
    String hello(String username);

    // skeletal
    @Slf4j
    abstract class AbstractUserLog implements UserLog {
        @Override
        public void print(String message) {
            log.info(hello(message));
        }
    }

    class Default implements UserLog {
        AbstractUserLog abstractUserLog = new Impl();

        private class Impl extends AbstractUserLog {
            @Override
            public String hello(String username) {
                return "hello " + username;
            }
        }

        @Override
        public void print(String msg) {
            abstractUserLog.print(msg);
        }

        @Override
        public String hello(String username) {
            return abstractUserLog.hello(username);
        }
    }
}
