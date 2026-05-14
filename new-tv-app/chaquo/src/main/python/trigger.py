import sys
from runner import exec

if __name__ == "__main__":
    if len(sys.argv) >= 3:
        script = sys.argv[1]
        method = sys.argv[2]
        args = sys.argv[3:] if len(sys.argv) > 3 else []
        result = exec(script, method, args)
        print(result)